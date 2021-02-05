import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/vue-admin-template/student/list',
    method: 'get',
    params
  })
}

export function createStudent(data) {
  return request({
    url: '/vue-element-admin/student/create',
    method: 'post',
    data
  })
}

export function updateStudent(data) {
  return request({
    url: '/vue-element-admin/student/update',
    method: 'post',
    data
  })
}
