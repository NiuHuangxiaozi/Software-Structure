



import axios from "axios";

// const baseURL = 'http://localhost:2222';
const baseURL = '/api';
const order_instance=axios.create({baseURL})


order_instance.interceptors.response.use(
    result =>{
        return result.data;
    },
    err=>{
        alert('服务异常')
        return Promise.reject(err);
    }
)

export default order_instance;

