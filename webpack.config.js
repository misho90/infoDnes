module.exports = {
    devtool: 'source-map',
    output: {
        filename: 'react-app.js'
    },
    module: {
        rules: [{
            test: /\.(js|jsx)$/,
            exclude: /node_modules/,
            loader: "babel-loader",
            options: {
                presets: ['@babel/preset-env', '@babel/preset-react']
            }
        }, {
            test: /\.css$/,
            exclude: /node_modules/,
            use: ['style-loader', 'css-loader']
        },
         {       test: /\.(jpe?g|png|jfif|gif|woff|woff2|eot|ttf|svg)$/i,
                use: [
                  {
                    loader: 'file-loader',
                    options: {
                      query: {
                        name:'assets/[name].[ext]'
                      }
                    }
                  },
                  {
                    loader: 'image-webpack-loader',
                    options: {
                      query: {
                        mozjpeg: {
                          progressive: true,
                        },
                        gifsicle: {
                          interlaced: true,
                        },
                        optipng: {
                          optimizationLevel: 7,
                        }
                      }
                    }
                  }]
        }]
    },
    resolve: {
        extensions: ['.js', '.jsx']
    }
};
