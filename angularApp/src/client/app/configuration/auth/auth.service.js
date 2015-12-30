(function() {
    'use strict';

    angular
        .module('app.configuration')
        .factory('AuthService', AuthService);

    /* @ngInject */
    function AuthService($http, $q, ENDPOINTS) {

        var endpoint = ENDPOINTS.host +'authSession/';

        return {
            login: login
        };

        function login(password) {

            var defered = $q.defer();
            var promise = defered.promise;

            $http.put(endpoint + password)
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
