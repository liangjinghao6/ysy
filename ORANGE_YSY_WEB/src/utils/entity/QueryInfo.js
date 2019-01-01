export default (st, queryMethod) => {//st页面this对象,queryMethod如果默认查询不是doQuery需要指定字符串
  let _thisst = st
  let query = {};
  let pageNum = 1;
  let pageSize = 20;
  let sort = 'updateTime';
  let order = 'desc'
  let selObj = []//checkbox勾选的对象
  let doQueryMethod = queryMethod ? '_thisst.' + queryMethod + "()" : "_thisst.doQuery()"

  let outObj = {

    query, pageNum, pageSize, sort, order, selObj, doQueryMethod,

    setThis(st) {
      _thisst = st
    },
    doSizeChg(val) {//显示行数切换
      outObj.pageSize = val
      return eval(doQueryMethod)
    },
    doCurPageChange(val) {//页码切换
      outObj.pageNum = val
      return eval(doQueryMethod)
    },
    doSort(val, noQuery) {
      outObj.sort = val.prop
      if (val.order == 'ascending') {
        outObj.order = 'asc'
      } else if (val.order == 'descending') {
        outObj.order = 'desc'
      } else {
        outObj.sort = ''
        outObj.order = ''
      }
      if (!noQuery) {//true 不查询,适合列表一加载时
        return eval(doQueryMethod)
      }
    }
  }
  return outObj
}

