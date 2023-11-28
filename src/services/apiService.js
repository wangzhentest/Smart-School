import axios from 'axios';

const apiService = axios.create({
    baseURL: 'http://localhost:8081',
});

export default {

    //Cameras----------------------------------------------------------------------
    async get_cameras(areaName) {
        try {
            const response = await apiService.get('/get_camera_list',{params: {areaName: areaName}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },

    //Incident----------------------------------------------------------------------
    async get_untreated_incidents() {
        try {
            const response = await apiService.get('/get_untreated_incidents');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    async get_treated_incidents() {
        try {
            const response = await apiService.get('/get_treated_incidents');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    async add_incident(camera_id,incident_type) {
        try {
            const response = await apiService.get('/add_incident', {params: {camera_id: camera_id,incident_type:incident_type,video:"test"}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    async appoint_staffs(incidentId,staffs_list) {
        try {
            const response = await apiService.get('/appoint_staffs', {params: {incidentId:incidentId,staffs_list: staffs_list}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    //Log----------------------------------------------------------------------
    async get_logs() {
        try {
            const response = await apiService.get('/get_logs');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    //Login----------------------------------------------------------------------
    async Login(account, pwd) {
        try {
            const response = await apiService.get('/Login', {params: {account: account, pwd: pwd}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    //staffs----------------------------------------------------------------------
    //Guards
    async get_guards() {
        try {
            const response = await apiService.get('/get_guards');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    //MedicalStaff
    async get_medical_staffs() {
        try {
            const response = await apiService.get('/get_medical_staffs');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    //Operates
    async get_users() {
        try {
            const response = await apiService.get('/get_users');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    //Repairman
    async get_repairmen() {
        try {
            const response = await apiService.get('/get_repairmen');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },

    //Message----------------------------------------------------------------------
    async get_messages() {
        try {
            const response = await apiService.get('/get_messages');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    async get_not_reminded_messages() {
        try {
            const response = await apiService.get('/get_not_reminded_messages');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    async remind_message(id) {
        try {
            const response = await apiService.get('/remind_message', {params: {id: id}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    async add_messages(camera_id,alarm_reason) {
        try {
            const response = await apiService.get('/add_messages', {params: {camera_id: camera_id,alarm_reason:alarm_reason}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },

    async delete_message(id,user_id) {
        try {
            const response = await apiService.get('/delete_message', {params: {id: id,user_id:user_id}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },

    //Summary----------------------------------------------------------------------
    async get_summaries() {
        try {
            const response = await apiService.get('/get_summaries');
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    async get_summary_by_id(incident_id) {
        try {
            const response = await apiService.get('/get_summary_by_id', {params: {incident_id: incident_id}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },

    //User----------------------------------------------------------------------
    async go_online(user_id) {
        try {
            const response = await apiService.get('/go_online', {params: {user_id: user_id}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    async down_online(user_id) {
        try {
            const response = await apiService.get('/down_online', {params: {user_id: user_id}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    async get_pwd(user_id) {
        try {
            const response = await apiService.get('/get_pwd', {params: {user_id: user_id}});
            return response.data;
        } catch (error) {
            throw new Error(error.response.data.message);
        }
    },
    //Video----------------------------------------------------------------------

};
