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
            template: '<div class="configValueBox"><div ng-repeat="elem in config">' +
                '<div>{{elem.id}}</div>' +
                '<div><input value="{{elem.value}}"></input></div>' +
                '</div></div>',
            link: function(scope, element, attrs, controller, transcludeFn) {
                ConfigurationService.get(scope.token)
                    .then(function(values) {
                        scope.config = values;
                    });
            }
        };
    }
})();
