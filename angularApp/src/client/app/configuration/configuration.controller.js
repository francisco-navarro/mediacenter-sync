(function() {
    'use strict';

    angular
        .module('app.configuration')
        .controller('ConfigurationController', ConfigurationController);

    /* @ngInject */
    function ConfigurationController(ConfigurationService, toastr) {

        var vm = this;

        activate();

        ////////////
        
        function activate() {
            vm.authToken = undefined;
        }

    }
})();
