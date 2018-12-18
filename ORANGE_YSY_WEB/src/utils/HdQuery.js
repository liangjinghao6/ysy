export default (st) => {//st页面this对象
  let others = {};
  let page = 1;
  let rows = 20;
  let q = '';
  let sort = 'updTimestamp';
  let order = 'desc'
  return {

    others, page, rows, q, sort, order,

    add: (key, value) => {
      others[key] = value
    },
    doSizeChg(val) {//显示行数切换
      st.hdQuery.rows = val
      st.doQuery()
    },
    doCurPageChange(val) {//页码切换
      st.hdQuery.page = val
      st.doQuery()
    },
    doSort(val) {
      st.hdQuery.sort = val.prop
      if (val.order == 'ascending') {
        st.hdQuery.order = 'asc'
      } else if (val.order == 'descending') {
        st.hdQuery.order = 'desc'
      } else {
        st.hdQuery.sort = ''
        st.hdQuery.order = ''
      }
      st.doQuery()
    },
    getParam() {

    }
  }
}

