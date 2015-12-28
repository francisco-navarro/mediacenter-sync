(function() {
    'use strict';

    angular
        .module('app.configuration')
        .directive('configBox', configBox);

    /* @ngInject */
    function configBox(ConfigurationService, toastr) {
        return {
            restrict: 'AE',
            replace: true,
            scope: {
                token: '='
            },
            templateUrl: 'app/configuration/config.box.template.html',
            controller: function($scope) {
                var vm = this;
                vm.submit = submit;
                init();

                function init() {
                    ConfigurationService.get($scope.token)
                        .then(function(values) {
                            vm.config = values;
                        });
                }

                function submit() {
                    ConfigurationService.updateValues(vm.config);
                }
            },
            controllerAs: 'vm'
        };
    }
})();
