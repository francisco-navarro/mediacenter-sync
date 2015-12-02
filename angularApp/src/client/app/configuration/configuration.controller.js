(function() {
    'use strict';

    angular
        .module('app.configuration')
        .controller('ConfigurationController', ConfigurationController);

    ConfigurationController.$inject = ['logger'];
    /* @ngInject */
    function ConfigurationController(logger) {
        var vm = this;

        init();

        function init() {
            logger.info('ConfigurationController loaded');
        }
    }
})();
