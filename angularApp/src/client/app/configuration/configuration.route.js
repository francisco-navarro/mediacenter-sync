(function() {
    'use strict';

    angular
        .module('app.configuration')
        .run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'configuration',
                config: {
                    url: '/configuration',
                    templateUrl: 'app/configuration/configuration.html',
                    controller: 'ConfigurationController',
                    controllerAs: 'vm',
                    title: 'Configuration',
                    settings: {
                        nav: 2,
                        content: '<i class="fa fa-lock"></i> Configuration'
                    }
                }
            }
        ];
    }
})();
