



import axios from "axios";

// const baseURL = 'http://localhost:2222';
const baseURL = '/api';
const deli_instance=axios.create({baseURL})


deli_instance.interceptors.response.use(
    result =>{
        return result.data;
    },
    err=>{
        alert('运单服务异常')
        return Promise.reject(err);
    }
)

export default  deli_instance;

