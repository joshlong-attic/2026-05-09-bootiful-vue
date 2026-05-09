<script setup lang="ts">

import {onMounted, ref} from "vue";
import Panel from "@/Panel.vue";

const message = ref('Hello Vue 3 + Vite')

onMounted(async () => {
  const result = await window.fetch('/api/message')
  const json = await result.json()
  message.value = json['message']
})

async function handle() {
  console.log('clicked')
  window.alert('clicked')
}

function handleFooEvent() {
  console.log('got the foo event')
}

</script>

<template>
  <h1 @click.prevent="handle">You did it!</h1>
  <p>
     Visit <a href="https://vuejs.org/" target="_blank" rel="noopener">vuejs.org</a> to read the
    documentation
  </p>
  <div>
    {{ message }}
  </div>

  <Panel @foo="handleFooEvent"/>

</template>

<style scoped>

h1 {
  font-size: 2em;
  color: #333;
}

</style>
