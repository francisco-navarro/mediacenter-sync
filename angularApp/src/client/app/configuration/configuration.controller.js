(function() {
    'use strict';

    angular
        .module('app.configuration')
        .controller('ConfigurationController', ConfigurationController);

    ConfigurationController.$inject = ['$scope', 'AuthService', 'toastr'];
    /* @ngInject */
    function ConfigurationController($scope, AuthService, toastr) {

        var vm = this;
        vm.login = login;

        init();

        function init() {
            vm.authToken = undefined;
        }

        function login() {
            AuthService.login(vm.password)
                .then(function(token) {
                    vm.authToken = token;
                    toastr.info('Login sucessfull');
                }, function() {
                    //Error
                    toastr.error('Login error');
                });
        }
    }
})();
