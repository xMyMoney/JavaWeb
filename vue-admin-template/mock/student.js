const Mock = require('mockjs')
const List = []
const count = 100

for (let i = 0; i < count; i++) {
  List.push(Mock.mock({
    id: '@id',
    username: '@name',
    'sex|1': [
      '男',
      '女'
    ],
    'age|1-100': 100,
    time: '@datetime',
    country: '@county(true)'
  }))
}

module.exports = [
  {
    url: '/vue-admin-template/student/list',
    type: 'get',
    response: config => {
      const { username, sex, page = 1, limit = 10 } = config.query

      const mockList = List.filter(item => {
        if (username && username !== item.username) return false
        if (sex && sex !== item.sex) return false
        return true
      })
      const pageList = mockList.filter((item, index) =>
        (index < limit * page && index >= limit * (page - 1))
      )
      return {
        code: 20000,
        data: {
          total: mockList.length,
          items: pageList
        }
      }
    }
  },

  {
    url: '/vue-element-admin/student/create',
    type: 'post',
    response: _ => {
      return {
        code: 20000,
        data: 'success'
      }
    }
  },

  {
    url: '/vue-element-admin/student/update',
    type: 'post',
    response: _ => {
      return {
        code: 20000,
        data: 'success'
      }
    }
  }
]
