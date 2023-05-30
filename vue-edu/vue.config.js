// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })
module.exports = {
  publicPath: './',
  devServer: {
    port: 8087,
    client: {
      overlay: false,
    },
    proxy: {
      [process.env.VUE_APP_BASE_API]: {
        target: `http://localhost:8088`,
        changeOrigin: true,
        pathRewrite: {
          ['^' + process.env.VUE_APP_BASE_API]: ''
        }
      }
    }
  }
}
