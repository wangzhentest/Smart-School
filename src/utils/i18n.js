import { createI18n } from 'vue-i18n';
import en from './en.json';
import zh from './zh.json';

const messages = {
    en,
    zh
};

const i18n = createI18n({
    legacy: false,
    locale: navigator.language,
    fallbackLocale: 'en',
    messages
});

export function setupI18n(app) {
    app.use(i18n);
}