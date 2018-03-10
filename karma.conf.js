// See http://karma-runner.github.io/1.0/config/configuration-file.html
module.exports = function(config) {
    config.set({
        frameworks: ['cljs-test'],

        basePath: 'target/out',

        // If you need to include custom JavaScript files, put them here.
        files: [
            // We serve all the JS files via Karma's webserver so that you can
            // use :optimizations :none. Only test_suite.js is included because
            // CLJS does its own module loading.
            'test_suite.js',
            { pattern: '**/*.js', included: false, served: true }
        ],

        client: {
            args: ['karma_demo.runner.run_all']
        },

        // If you don't like the progress reporter, you could try 'dots'
        reporters: ['progress', 'junit'],

        // If you want to use other browsers, you need to install the launchers
        // for them! E.g. npm install --save-dev karma-firefofx-launcher
        browsers: ['Chrome'],

        reportSlowerThan: 500, // ms

        // We disable autoWatch, because it executes tests while the code is
        // still comiling. We use :notify-command to trigger them instead.
        autoWatch: false,

        // Configuration for JUnit output. We care only about the output directory.
        // This directory is relative to basePath, so the XML files will be 
        // in `target/out/reports`.
        // <https://github.com/karma-runner/karma-junit-reporter#configuration>
        junitReporter: {
            outputDir: 'reports'
        }
    });
}
