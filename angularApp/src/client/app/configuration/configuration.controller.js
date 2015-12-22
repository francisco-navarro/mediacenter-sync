(function() {
    'use strict';

    angular
        .module('app.configuration')
        .controller('ConfigurationController', ConfigurationController);

    /* @ngInject */
    function ConfigurationController(ConfigurationService, toastr) {

        var vm = this;

        init();

        function init() {
            vm.authToken = undefined;
        }

    }
})();
