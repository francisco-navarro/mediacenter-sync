(function() {
    'use strict';

    angular
        .module('app.configuration')
        .directive('configBox', configBox);

    /* @ngInject */
    function configBox(ConfigurationService, toastr) {
        return {
            restrict: 'E',
            replace: true,
            scope: {
                token: '='
            },
            templateUrl: 'app/configuration/config.box.template.html',
            controller: function($scope) {
                var vm = this;
                vm.submit = submit;
                activate();

                function activate() {
                    ConfigurationService.get($scope.token).then(function(values) {
                            vm.config = values;
                        });
                }

                function submit() {
                    ConfigurationService.update($scope.token,vm.config)
                        .then(function(){
                            activate();
                            toastr.info('Changes saved');
                        });
                }
            },
            controllerAs: 'vm'
        };
    }
})();
