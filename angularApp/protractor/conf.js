exports.config = {
  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['test/controller/*.js'],
  /*allScriptsTimeout: 13000,
  pageLoadTimeout: 19000,
  getPageTimeout: 12000,*/
  capabilities: {
    browserName: 'chrome'
  }
};