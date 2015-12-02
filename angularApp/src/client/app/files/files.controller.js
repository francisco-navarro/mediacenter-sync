(function() {
  'use strict';

  angular
    .module('app.files')
    .controller('FilesController', DashboardController);

  DashboardController.$inject = ['logger'];
  /* @ngInject */
  function DashboardController(logger) {
    var vm = this;

    init();

    function init() {
      logger.info('Files controller loaded');
    }
  }
})();
