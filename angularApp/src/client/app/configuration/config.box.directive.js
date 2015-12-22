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
            template: '<div><div ng-repeat="elem in config>{{elem}}</div></div>',
            link: function(scope, element, attrs, controller, transcludeFn) {
                scope.config = ConfigurationService.get(scope.token);
            }
        };
    }
})();
