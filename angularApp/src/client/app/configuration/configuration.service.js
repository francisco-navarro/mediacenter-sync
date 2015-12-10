(function() {
    'use strict';

    angular
        .module('app.files')
        .factory('ConfigurationService', ConfigurationService);

    ConfigurationService.$inject = ['$http'];
    /* @ngInject */
    function ConfigurationService($http) {

        var host = '';
        var endpoint = 'api/configuration/';

        return {
            get: get
        };

        function get(token) {

            return $http.get(host + endpoint + '?token='+token )
                .then(function(response) {
                    return response.data;
            });

        }
    }
})();
