module.exports = function(config) {
    config.set({
        frameworks: ['cljs-test'],

        files: [
            'target/test_suite.js'
        ],

        client: {
            args: ['karma_demo.runner.run_all']
        },

        reporters: ['progress', 'junit'],
        browsers: ['Chrome'],
        autoWatch: false,

        reportSlowerThan: 500, // ms

        junitReporter: {
            outputDir: 'target/reports'
        }
    });
}
