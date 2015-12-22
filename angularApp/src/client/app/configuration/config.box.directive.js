(function() {
    'use strict';

    angular
        .module('app.configuration')
        .directive('configBox', configBox);

    /* @ngInject */
    function configBox(ConfigurationService) {
        return {
            restrict: 'AE',
            replace: true,
            scope: {
                token: '='
            },
            templateUrl: 'app/configuration/config.box.template.html',
            link: function(scope, element, attrs, controller, transcludeFn) {
                ConfigurationService.get(scope.token)
                    .then(function(values) {
                        scope.config = values;
                    });
            }
        };
    }
})();
