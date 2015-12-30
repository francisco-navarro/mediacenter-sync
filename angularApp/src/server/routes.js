var router = require('express').Router();
var four0four = require('./utils/404')();
var jsonParser = require('body-parser').json();
////////////// MOCKS in /api/
// More info in https://www.npmjs.com/package/express-api-server
router.route('/files')
	.get(require('./mocks/files').get);

router.route('/authSession/*')
	.put(jsonParser, require('./mocks/auth').put);

router.route('/configuration/*')
	.get(require('./mocks/configuration').get)
	.put(jsonParser, require('./mocks/configuration').put);
////
module.exports = router;