var ExtractTextPlugin = require("extract-text-webpack-plugin");

var extractDesignSASS = new ExtractTextPlugin('design/app.css');

module.exports = {
    'entry': {
        'design/app.css': './front-end/styles/app.scss'
    },
    'output': {
        'filename': '[name]',
    },
    'module': {
        'loaders': [
            {
                'test': /front-end\/styles\/app.scss$/,
                'loader': extractDesignSASS.extract(['css', 'sass'])
            },
            {
                'test': /\.(eot|woff|woff2|ttf|svg|png|jpe?g|gif)(\?\S*)?$/,
                'loader': 'url'
            }
        ]
    },
    plugins: [ extractDesignSASS ]
};