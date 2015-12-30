var configuration = {
	  remoteUser: null,
	  remoteIp: null,
	  remotePath: null,
	  remotePassword: null,
	  adminPassword: '1234'
};
exports.get = function(req, res) {
	 res.json(configuration);
}
exports.put = function(req, res) {
	configuration = req.body;
	res.status(200);
	res.json({});
}