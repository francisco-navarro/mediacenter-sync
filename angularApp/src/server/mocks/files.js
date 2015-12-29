exports.get = function(req, res, next) {
  var todos = {
    'info': 'infoResult'
  };
  res.json(todos);
};
