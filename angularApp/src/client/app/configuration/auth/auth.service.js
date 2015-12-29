(function() {
    'use strict';

    angular
        .module('app.configuration')
        .factory('AuthService', AuthService);

    /* @ngInject */
    function AuthService($http, $q) {

        var host = '';
        var endpoint = 'api/authSession/';

        return {
            login: login
        };

        function login(password) {

            var defered = $q.defer();
            var promise = defered.promise;

            $http.put(host + endpoint + password)
                .then(function(response) {
                    if (response.data.token !== undefined) {
                        defered.resolve(response.data.token);
                    } else {
                        defered.reject();
                    }
                }, function() {
                    defered.reject();
                });
            return promise;
        }
    }
})();
