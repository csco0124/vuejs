import Vue from 'vue'
import VueI18n from 'vue-i18n'

Vue.use(VueI18n);

const messages = {
  en: {
    message: {
      hello: 'hello world',
      lenguage: 'language',
      currentLink: 'Current link'
    }
  },
  ko: {
    message: {
      hello: '안녕하세요',
      lenguage: '언어',
      currentLink: '현재링크'
    }
  }
}

const i18n = new VueI18n({
  locale: 'ko',
  messages
})


export default i18n