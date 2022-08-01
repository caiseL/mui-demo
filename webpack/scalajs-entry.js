if (process.env.NODE_ENV === "production") {
    const opt = require("./mui-opt.js");
    opt.main();
    module.exports = opt;
} else {
    var exports = window;
    exports.require = require("./mui-fastopt-entrypoint.js").require;
    window.global = window;

    const fastOpt = require("./mui-fastopt.js");
    fastOpt.main()
    module.exports = fastOpt;

    if (module.hot) {
        module.hot.accept();
    }
}
