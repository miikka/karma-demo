Demonstration of how to use Karma to run ClojureScript tests in Chrome (with
JUnit output and slow test reporting).

Start the Karma server:

    npm install
    ./node_modules/karma-cli/bin/karma start

In another terminal, start cljsbuild:

    lein cljsbuild auto

Now go and edit some of the `.cljs` files. The tests should be automatically
run. You can also manually start a test run with `./trigger-karma.sh`.
