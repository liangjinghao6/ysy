function genRules(isRequired, minLength, maxLength, type = 'string', decimalNum) { // decimalNum=0是整数
  const result = []
  if (isRequired) {
    const msg = {message: this.$t('此处必填'), required: true}
    result.push(msg)
  }
  if (type == 'string') {
    if (minLength) {
      result.push({min: minLength, message: this.$t('字符长度不能小于x个字符', [minLength])})
    }
    if (maxLength) {
      result.push({max: maxLength, message: this.$t('字符长度不能大于x个字符', [maxLength])})
    }
  } else if (type == 'number') {
    result.push({type: 'number', message: this.$t('必须为数字')})
    if (minLength != null) {
      result.push({type: 'number', min: minLength, message: this.$t('数字不能小于x', [minLength])})
    }
    if (maxLength) {
      result.push({type: 'number', max: maxLength, message: this.$t('数字不能大于{0}', [maxLength])})
    }
    if (decimalNum) { // 非0时,有小数
      const reg = new RegExp('^(\\-|\\+?)\\d+(\\.\\d{0,' + decimalNum + '})?$')
      result.push({pattern: reg, message: this.$t('小数最多{0}位', [decimalNum])}
      )
    }
    if (decimalNum === 0) {
      const reg = new RegExp('(^-?\\d+$)')
      result.push({pattern: reg, message: this.$t('请输入整数')}
      )
    }
  }

  return result
}

function ckFt(value) { // checkbox展示用
  if (value == '1') {
    return '√'
  } else {
    return '×'
  }
}

function date() {
  return
}

export default {

  install(Vue) {
    Vue.prototype.$r = genRules
    Vue.prototype.$ckFt = ckFt
    Vue.prototype.$date = {
      type: 'date',
      placeholder: '选择日期',
      format: 'yyyy-MM-dd',
      valueFormat: 'yyyy-MM-dd',
      style: {width: '100%'}
    }
    Vue.prototype.$time = {
      type: 'datetime',
      placeholder: '选择时间',
      format: 'yyyy-MM-dd HH:mm',
      valueFormat: 'yyyy-MM-dd HH:mm',
      style: {width: '100%'}
    }
    Vue.prototype.$simdate = {
      type: 'date',
      placeholder: '选择日期',
      format: 'yy-MM-dd',
      valueFormat: 'yyyy-MM-dd',
      style: {width: '100%'}
    }
    Vue.prototype.$simtime = {
      type: 'datetime',
      placeholder: '选择时间',
      format: 'yy-MM-dd HH:mm',
      valueFormat: 'yyyy-MM-dd HH:mm',
      style: {width: '100%'}
    }
    Vue.prototype.$simdateshow = (v) => {
      if (v) {
        return v.substring(2, 10)
      } else {
        return ''
      }
    }
    Vue.prototype.$simtimeshow = (v) => {
      if (v) {
        return v.substring(2)
      } else {
        return ''
      }
    }
  }
}
