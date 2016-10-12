var path = require('path');

var express = require('express')
var app = express()

app.use(express.static(path.join(__dirname, 'assets')));

app.get('/', function (req, res) {
  res.send('Hello World')
})

app.listen(3000)