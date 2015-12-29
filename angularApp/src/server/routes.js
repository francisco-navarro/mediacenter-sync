var router = require('express').Router();
var four0four = require('./utils/404')();



////////////// MOCKS in /api/
// More info in https://www.npmjs.com/package/express-api-server

var files = require('./mocks/files');

router.route('/files').get(files.get);

//////////////////
module.exports = router;