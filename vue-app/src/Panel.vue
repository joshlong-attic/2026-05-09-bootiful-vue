<script setup lang="ts">
const emit = defineEmits(['foo'])

function handle() {
  emit('foo', 123)
}
</script>

<template>
  <h1> Panel </h1>
  <a href="#" @click.prevent="handle">
    inner event
  </a>
</template>

<style scoped>
h1 {
  color: red;
}
</style>