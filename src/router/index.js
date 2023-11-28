import { createRouter, createWebHistory } from 'vue-router'
import LoginIn from '../views/LoginIn.vue'
import MainPage from '../views/MainPage.vue'
import View403 from "../views/View403.vue"
import View404 from "../views/View404.vue"
import SchoolModel from '../components/views/SchoolModel.vue'
import IncidentReport from "../components/views/IncidentReport.vue";
import Incidents from "../components/views/Incidents.vue";
import Monitoring from "../components/views/Monitoring.vue";
import Staffs from "../components/views/Staffs.vue";
import SystemLogs from "../components/views/SystemLogs.vue";
import TreatedIncidents from "../components/views/Incidents/TreatedIncidents.vue";
import UntreatedIncidents from "../components/views/Incidents/UntreatedIncidents.vue";
import Guards from "../components/views/Staffs/Guards.vue";
import MedicalStaffs from "../components/views/Staffs/MedicalStaffs.vue";
import Operator from "../components/views/Staffs/Operator.vue";
import Repairmen from "../components/views/Staffs/Repairmen.vue";
import Report from  "../components/commen/Report.vue";



const routes = [
    {
        path: '/',
        name: 'LoginIn',
        component: LoginIn
    },
    {
        path: '/View403',
        name: 'View403',
        component: View403
    },
    {
        path: '/View404',
        name:'View404',
        component: View404,
    },
    {
        path: '/MainPage',
        name: 'MainPage',
        component: MainPage,
        children: [
            {
                path: '/SchoolModel',
                name:'SchoolModel',
                component: SchoolModel,
            },
            {
                path: '/Monitoring',
                name:'Monitoring',
                component: Monitoring,
            },
            {
                path: '/Incidents',
                name:'Incidents',
                component: Incidents,
                children: [
                    {
                        path: '/TreatedIncidents',
                        name:'TreatedIncidents',
                        component: TreatedIncidents,
                    },
                    {
                        path: '/UntreatedIncidents',
                        name:'UntreatedIncidents',
                        component: UntreatedIncidents,
                    }
                ]
            },
            {
                path: '/Staffs',
                name:'Staffs',
                component: Staffs,
                children: [
                    {
                        path: '/Guards',
                        name:'Guards',
                        component: Guards,
                    },
                    {
                        path: '/MedicalStaffs',
                        name:'MedicalStaffs',
                        component: MedicalStaffs,
                    },
                    {
                        path: '/Operator',
                        name:'Operator',
                        component: Operator,
                    },
                    {
                        path: '/Repairmen',
                        name:'Repairmen',
                        component: Repairmen,
                    }
                ]
            },
            {
                path: '/IncidentReport',
                name:'IncidentReport',
                component: IncidentReport,
                children: [
                    {
                        path: '/Report',
                        name:'Report',
                        component: Report
                    }
                ]
            },
            {
                path: '/SystemLogs',
                name:'SystemLogs',
                component: SystemLogs,
            },
        ]
    },
]

const index = createRouter({
    history: createWebHistory(),
    routes
})

export default index
