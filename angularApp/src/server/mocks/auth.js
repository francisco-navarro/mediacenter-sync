var errors = require('express-api-server').errors;

exports.put = function(req, res, next) {
  if (!req.params[0] || req.params[0].length === 0) {
    return next(new errors.BadRequestError());
  }
  res.status(200);
  res.json({
    token: '123123'
  });
};
