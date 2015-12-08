(function() {
    'use strict';

    angular
        .module('app.configuration')
        .controller('ConfigurationController', ConfigurationController);

    ConfigurationController.$inject = [];
    /* @ngInject */
    function ConfigurationController() {
        var vm = this;

        init();

        function init() {
            vm.authToken = undefined;
        }
    }
})();
