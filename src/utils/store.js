// store.js
import { reactive } from 'vue'

const state = reactive({
    model: null
})

const mutations = {
    setModel(newModel) {
        state.model = newModel
    }
}

export default {
    state,
    mutations
}
