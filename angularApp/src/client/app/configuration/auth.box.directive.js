(function() {
    'use strict';

    angular
        .module('app.files')
        .directive('authBox', authBox);

    /* @ngInject */
    function authBox(AuthService, toastr) {        
        return {
            restrict: 'AE',
            replace: false,
            scope: {
                token: '='
            },
            transclude: true,
            templateUrl: 'app/configuration/auth.box.template.html',
            link: function(scope, element, attrs, controller, transcludeFn) {
                scope.login = function() {
                    AuthService.login(scope.boxPassword)
                        .then(function(response) {
                            scope.token = response;
                            scope.logged = true;
                            toastr.info('Login sucessfull');
                        }, function() {
                            //Error
                            scope.logged = false;
                            toastr.error('Login error');
                        });
                };
            }
        };
    }
})();
