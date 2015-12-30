(function() {
    'use strict';

    angular
        .module('app.files')
        .factory('ConfigurationService', ConfigurationService);

    /* @ngInject */
    function ConfigurationService($http, ENDPOINTS) {

        var endpoint = ENDPOINTS.host + 'configuration/';

        return {
            get: get,
            update: update
        };

        function get(token) {
            return $http.get(endpoint + '?token=' + token)
                .then(function(response) {
                    return response.data;
                });
        }

        function update(token, config){
            return $http.put(endpoint + '?token=' + token,
                config);
        }
    }
})();
