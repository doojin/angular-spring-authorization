var ExtractTextPlugin = require("extract-text-webpack-plugin");

var extractDesignSASS = new ExtractTextPlugin('design/app.css');
var extractProductionSASS = new ExtractTextPlugin('src/main/webapp/static/css/app.css');

module.exports = {
    entry: {
        'src/main/webapp/static/js/app.js': './front-end/js/app.js',
        // 'design/app.css': './front-end/styles/app.scss'
        'src/main/webapp/static/css/app.css': './front-end/styles/app.scss'
    },
    output: {
        filename: '[name]'
    },
    module: {
        loaders: [
            // {
            //     test: /front-end\/styles\/app.scss$/,
            //     loader: extractDesignSASS.extract(['css', 'sass'])
            // },
            {
                test: /front-end\/styles\/app.scss$/,
                loader: extractProductionSASS.extract(['css', 'sass'])
            },
            {
                test: /\.(eot|woff|woff2|ttf|svg|png|jpe?g|gif)(\?\S*)?$/,
                loader: 'url'
            },
            {
                test: /\.js$/,
                loader: 'babel',
                query: {
                    presets: ['es2015']
                }
            }
        ]
    },
    plugins: [ extractDesignSASS, extractProductionSASS ]
};