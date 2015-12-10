(function() {
    'use strict';

    angular
        .module('app.files')
        .directive('authBox', authBox);

    authBox.$inject = ['AuthService', 'toastr'];
    /* @ngInject */
    function authBox(AuthService, toastr) {


        return {
            restrict: 'AE',
            replace: true,
            scope: {
                token: '=',
                loginFn: '&'
            },
            template: '<div class="login center" ng-show="!token"><div class="row"></div><div>Password</div><div>' +
                '<input type="password" ng-model="boxPassword" />' +
                '</div><div class="center">' +
                '<button class="btn btn-default" ng-click="login()">Login</button></div></div>',
            link: function(scope, element) {
                scope.login = function() {
                    AuthService.login(scope.boxPassword)
                        .then(function(response) {
                            scope.token = response;
                            toastr.info('Login sucessfull');
                        }, function() {
                            //Error
                            toastr.error('Login error');
                        });
                };
            }
        };
    }
})();
