# Running ClojureScript tests with Karma

This repository demonstrates how to use [Karma][karma] to run ClojureScript
tests in Chrome with JUnit output and slow test reporting.

First of all, if [doo][doo] fits your needs, by all means use it. Doo can run
Karma just fine. The trouble is that
[you can't really configure Karma with doo][doo-43]. Here are some reasons for
why I've wanted to configure Karma:

* I wanted to include a collection of JavaScript files to be executed - in the
  correct order - before the tests.
* I wanted to get JUnit output for the tests.

Luckily it's straightforward to use Karma directly!


## How to build and run the tests

Start the Karma server:

    npm install
    ./node_modules/karma-cli/bin/karma start

In another terminal, start cljsbuild:

    lein cljsbuild auto

Now go and edit some of the `.cljs` files. The tests should be automatically
run. You can also manually start a test run with `./trigger-karma.sh`. The JUnit
files are under `target/out/reports`.


## How does this work?

Basically we do what doo does, but manually. We use
[lein-cljsbuild][lein-cljsbuild] and [karma-reporter][karma-reporter]. Here are
the important files:

* [`package.json`](./package.json) lists the Karma components we need to install
  from npm.
* [`karma_demo/runner.cljs`](./test/cljs/karma_demo/runner.cljs) is our test
  runner namespace. It requires all the test namespaces and calls
  `jx.reporter.karma/run-all-tests`.
* [`project.clj`](./project.clj) configures cljsbuild to compile the test runner.
* [`karma.conf.js`](./karma.conf.js) is our Karma configuration. It points
  Karma to the compiled JavaScript files, configures the JUnit output etc.
  
I've included some comments into the files to draw attention to the interesting
parts.
  
We do not use Karma's autowatch feature, because it tends to re-run the tests
while cljsbuild is still compiling them. Instead we set cljsbuild's
`:notify-command` to trigger the tests when the build is ready. I've tried to
play with `autoWatchBatchDelay` option, but it's hard to get right.

[karma]: http://karma-runner.github.io/
[doo]: https://github.com/bensu/doo
[doo-43]: https://github.com/bensu/doo/issues/43
[boot-cljs-test]: https://github.com/crisptrutski/boot-cljs-test
[karma-reporter]: https://github.com/honzabrecka/karma-reporter
[lein-cljsbuild]: https://github.com/emezeske/lein-cljsbuild
