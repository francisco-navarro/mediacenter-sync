(function() {
    'use strict';

    angular
        .module('app.files')
        .factory('FilesService', FilesService);

    FilesService.$inject = ['$http'];
    /* @ngInject */
    function FilesService($http) {

        var host = '';
        var endpoint = 'api/files/';

        return {
            find: find,
            save: save,
            discard: discard,
            reset: reset
        };

        function find(status) {

            var uri = host + endpoint;
            if (status) {
                uri += '?status=' + status;
            }

            return $http.get(uri)
                .then(function(response) {
                    return response.data;
                });
        }

        function save(item) {
            item.status = '...';
            return $http.put(host + endpoint + item.id, {
                status: 'DOWNLOAD'
            });
        }

        function discard(item) {
            item.status = '...';
            return $http.put(host + endpoint + item.id, {
                status: 'DISCARDED'
            });
        }

        function reset(item) {
            item.status = '...';
            return $http.put(host + endpoint + item.id, {
                status: 'PENDING'
            });
        }
    }
})();
