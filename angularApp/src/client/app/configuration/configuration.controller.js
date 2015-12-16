(function() {
    'use strict';

    angular
        .module('app.configuration')
        .controller('ConfigurationController', ConfigurationController);

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
