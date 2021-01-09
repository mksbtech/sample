<template>
  <div v-if="validationStatus.$error">
    <p v-for="$error in validationStatus.$errors" :key="$error.$property">
      {{ $error.$message }}
    </p>
  </div>
</template>
<script>
export default {
  name: "ErrorMessage",
  props: {
    validationStatus: {
      type: Object,
      required: true
    },
  }
};
</script>