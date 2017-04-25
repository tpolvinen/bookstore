module.exports = {
  entry: './src/main/webapp/public/App.js',
 
  output: {
    path: __dirname + '/src/main/webapp/public', 
    filename: 'bundle.js' 
  },
  module: {
	    loaders: [
	      {
	        test: /.js$/,
	        loader: 'babel-loader',
	        exclude: /node_modules/,
	        query: {
	          presets: ['es2015', 'react']
	        }
	      }
	    ]
	  } 
};