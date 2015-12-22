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
            template: '<div class="login center" ng-show="!logged"><div class="row"></div>' +
                '<div>Password</div><div><input type="password" ng-model="boxPassword" />' +
                '</div><div class="center">' +
                '<button class="btn btn-default" ng-click="login()">Login</button></div></div>',
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
