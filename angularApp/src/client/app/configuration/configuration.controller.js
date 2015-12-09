(function() {
    'use strict';

    angular
        .module('app.configuration')
        .controller('ConfigurationController', ConfigurationController);

    ConfigurationController.$inject = ['ConfigurationService', 'toastr'];
    /* @ngInject */
    function ConfigurationController(ConfigurationService, toastr) {

        var vm = this;
        vm.loadConfig = loadConfig;

        init();

        function init() {
            vm.authToken = undefined;
        }

        function loadConfig() {
            ConfigurationService.get(vm.authToken)
                .then(function(data) {
                    vm.config = data;
                });
        }
    }
})();
